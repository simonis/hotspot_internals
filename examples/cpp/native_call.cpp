#include <jni.h>
#include <stdio.h>
#include <unistd.h>

/*
g++ -fPIC -shared -I jdk/include -I jdk/include/linux/ -o libnative_call.so native_call.cpp
-Djava.library.path=
*/

extern "C" {
/*
 * Class:     org_simonis_NativeWithGC
 * Method:    native_call
 * Signature: ([JJZ)V
 */
JNIEXPORT void JNICALL Java_org_simonis_NativeWithGC_native_1call(JNIEnv* env, jclass cls, jlongArray a, jlong s, jboolean block) {
  jboolean isCopy;
  jlong *la;
  if (block) {
    la = (jlong*)env->GetPrimitiveArrayCritical(a, &isCopy);
  }
  else {
    la = env->GetLongArrayElements(a, &isCopy);
  }
  fprintf(stderr, "%s\n", isCopy ? "It's a copy" : "It's the original");
  sleep(s);
  if (block) {
    env->ReleasePrimitiveArrayCritical(a, la, 0);
  }
  else {
    env->ReleaseLongArrayElements(a, la, 0);
  }
}

}
