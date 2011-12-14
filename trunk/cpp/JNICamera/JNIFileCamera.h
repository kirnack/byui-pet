/* 
 * File:   JNIFileCamera.h
 * Author: kirnack
 *
 * Created on November 29, 2011, 5:19 PM
 */

#ifndef JNIFILECAMERA_H
#define	JNIFILECAMERA_H
#include <string>
using namespace std;

#ifdef _WIN32_ || __WIN32 || WIN32
#define PATH_STRING wstring
#else
#define PATH_STRING string
#endif

struct imageTable
{
   int x;
   int y;
   char* data;
};

class JNIFileCamera {
public:
    JNIFileCamera();
    JNIFileCamera(const JNIFileCamera& orig);
    imageTable* getData();
    void moveNext();
    void movePrevious();
    virtual ~JNIFileCamera();
private:
    int size;
    int max;
    int pos;
    imageTable* files;
    void parseImageTable(PATH_STRING path);
};

#endif	/* JNIFILECAMERA_H */

