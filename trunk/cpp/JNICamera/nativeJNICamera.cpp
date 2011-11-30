
#include <edu_byui_PET_camera_JNICamera.h>
#include "JNIFileCamera.h"

/*
 * Class:     edu_byui_PET_camera_JNICamera
 * Method:    createCamera
 * Signature: ()J
 */
JNIEXPORT jlong JNICALL Java_edu_byui_PET_camera_JNICamera_createCamera
  (JNIEnv * env, jobject jobj)
{
    JNIFileCamera* cam = new JNIFileCamera();
    return (jlong) cam;
}

/*
 * Class:     edu_byui_PET_camera_JNICamera
 * Method:    getCameraData
 * Signature: (JJ)[B
 */
JNIEXPORT jbyteArray JNICALL Java_edu_byui_PET_camera_JNICamera_getCameraData
  (JNIEnv * env, jobject jobj, jlong ptr, jlong size)
{
    JNIFileCamera* cam = (JNIFileCamera*) ptr;
    jbyteArray dataArray = env->NewByteArray(size);
    
    char* data = cam->getData()->data;
    env->SetByteArrayRegion(dataArray, 0, size, (jbyte*)data);
    cam->moveNext();
    return dataArray;   
}

/*
 * Class:     edu_byui_PET_camera_JNICamera
 * Method:    getXResolution
 * Signature: (J)I
 */
JNIEXPORT jint JNICALL Java_edu_byui_PET_camera_JNICamera_getXResolution
  (JNIEnv * env, jobject jobj, jlong ptr)
{
    JNIFileCamera* cam = (JNIFileCamera*) ptr;
    jint x = cam->getData()->x;
    return x;
}

/*
 * Class:     edu_byui_PET_camera_JNICamera
 * Method:    getYResolution
 * Signature: (J)I
 */
JNIEXPORT jint JNICALL Java_edu_byui_PET_camera_JNICamera_getYResolution
  (JNIEnv * env, jobject jobj, jlong ptr)
{
    JNIFileCamera* cam = (JNIFileCamera*) ptr;
    jint y = cam->getData()->y;
    return y;
}