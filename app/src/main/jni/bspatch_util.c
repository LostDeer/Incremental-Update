//
// Created by Administrator on 2016/11/28.
//
#include "meng_hotup_utils_BsPatchUtil.h"
JNIEXPORT jint JNICALL Java_meng_hotup_utils_BsPatchUtil_patch
  (JNIEnv *env, jclass clazz, jstring old, jstring new, jstring patch){
          int args=4;
          char *argv[args];
          argv[0] = "bspatch";
          argv[1] = (char*)((*env)->GetStringUTFChars(env, old, 0));
          argv[2] = (char*)((*env)->GetStringUTFChars(env, new, 0));
          argv[3] = (char*)((*env)->GetStringUTFChars(env, patch, 0));

          int ret = executePatch(args, argv);

          (*env)->ReleaseStringUTFChars(env, old, argv[1]);
          (*env)->ReleaseStringUTFChars(env, new, argv[2]);
          (*env)->ReleaseStringUTFChars(env, patch, argv[3]);

          return ret;
  }

