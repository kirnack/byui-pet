/* 
 * File:   JNIFileCamera.h
 * Author: kirnack
 *
 * Created on November 29, 2011, 5:19 PM
 */

#ifndef JNIFILECAMERA_H
#define	JNIFILECAMERA_H

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
};

#endif	/* JNIFILECAMERA_H */

