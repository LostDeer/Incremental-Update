LOCAL_PATH := $(call my-dir)

include $(CLEAR_VARS)

LOCAL_MODULE     := ApkPatchLibrary
LOCAL_SRC_FILES  := bspatch_util.c

LOCAL_LDLIBS     := -lz -llog

include $(BUILD_SHARED_LIBRARY)