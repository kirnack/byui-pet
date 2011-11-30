/* 
 * File:   JNIFileCamera.cpp
 * Author: kirnack
 * 
 * Created on November 29, 2011, 5:19 PM
 */

#include "JNIFileCamera.h"

#include <fstream>
#include <string>

#include <dirent.h>
#include <unistd.h>
#include <sys/stat.h>
#include <sys/types.h>

char* getDIR();
#define HOME_DIR getDIR()

#ifdef _WIN32_
#include <windows.h>
char* getDIR()
{
   WCHAR path[MAX_PATH];
   HRESULT hr = SHGetFolderPath(NULL, CSIDL_PERSONAL, NULL,
                                SHGFP_TYPE_CURRENT, path);
   return path;
}
#else
#include <pwd.h>
#include <sys/types.h>

char* getDIR()
{
   return getpwuid(getuid())->pw_dir;
}
#endif


using namespace std;

JNIFileCamera::JNIFileCamera() {
  
  ifstream fin;
  string filepath;
  string dir = HOME_DIR;
  dir += "/.petdata";
  size = 0;
  pos = 0;
  max = 10;
  files = new imageTable[max];
  DIR *dp;
  struct dirent *dirp;
  struct stat filestat;
  dp = opendir( dir.c_str() );
  if (dp == NULL)
  {
      exit(1);
  }

  while ((dirp = readdir( dp )))
  {
      if (size == max)
      {
          max += 10;
          imageTable* temp = new imageTable[max];
          for(int i = 0; i < size; i ++)
              temp[i] = files[i];
          delete [] files;
          files = temp;
      }
    filepath = dir + "/" + dirp->d_name;

    // If the file is a directory (or is in some way invalid) we'll skip it 
    if (stat( filepath.c_str(), &filestat )) continue;
    if (S_ISDIR( filestat.st_mode ))         continue;

    // Endeavor to read a single number from the file and display it
    fin.open( filepath.c_str() );
    char num[4];
    fin.read(num, 3);
    files[size].x = atoi(num);
    fin.read(num, 3);
    files[size].y = atoi(num);
    files[size].data = new char[files[size].x * files[size].y];
    fin.read(files[size].data, files[size].x * files[size].y);
    size++;
    fin.close();
  }

  closedir( dp );
}

JNIFileCamera::JNIFileCamera(const JNIFileCamera& orig)
{
    size = orig.size;
    pos = orig.pos;
    max = orig.max;
    files = new imageTable[max];
    for (int i = 0; i < size; i++)
        files[i] = orig.files[i];
}

JNIFileCamera::~JNIFileCamera()
{
    if (files != NULL)
        delete [] files;
}

imageTable* JNIFileCamera::getData()
{
    return (files + pos);
}

void JNIFileCamera::moveNext()
{
    pos = (pos + 1) % size;
}

void JNIFileCamera::movePrevious()
{
    pos = (pos + size - 1) % size;
}
