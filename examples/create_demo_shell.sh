
export PS1="\[\e]0;\w\a\]\n\[\e[32m\]\u@\h \[\e[33m\]\w\[\e[0m\]\n\$ "

export PATH=/share/output-jdk9-hs-comp-dbg/images/jdk/bin:$PATH

#export _JAVA_OPTIONS='-Xbatch -XX:-UseCompressedOops -XX:+UseSerialGC -XX:-TieredCompilation -XX:-UseOnStackReplacement -XX:+UnlockDiagnosticVMOptions -XX:-CheckIntrinsics -XX:-LogVMOutput -XX:CICompilerCount=2'

if [ "$1" == "null_check" ]; then
export CLASSPATH=../bin/
export _JAVA_OPTIONS='-Xbatch -XX:-UseCompressedOops -XX:+UseSerialGC -XX:-UseOnStackReplacement -XX:-TieredCompilation -XX:CICompilerCount=1 -XX:LoopUnrollLimit=0 -XX:CompileCommand="option org.simonis.NullCheck*::swap* PrintOptoAssembly" -XX:CompileCommand="compileonly org.simonis.NullCheck*::*" -XX:CompileCommand="quiet" -XX:+PrintCompilation -XX:-LogVMOutput'
else
if [ "$1" == "null_check_coop" ]; then
export _JAVA_OPTIONS='-Xbatch -XX:HeapBaseMinAddress=0x8000000000000000 -Xlog:gc* -XX:+UseSerialGC -XX:-UseOnStackReplacement -XX:-TieredCompilation -XX:CICompilerCount=1 -XX:LoopUnrollLimit=0 -XX:CompileCommand="option org.simonis.NullCheck*::swap* PrintOptoAssembly" -XX:CompileCommand="compileonly org.simonis.NullCheck*::*" -XX:CompileCommand="quiet" -XX:+PrintCompilation -XX:-LogVMOutput'
else
if [ "$1" == "signal" ]; then
export _JAVA_OPTIONS='-Xbatch -XX:HeapBaseMinAddress=0x8000000000000000 -Xlog:gc* -XX:+UseSerialGC -XX:-UseOnStackReplacement -XX:-TieredCompilation -XX:CICompilerCount=1 -XX:LoopUnrollLimit=0  -XX:CompileCommand="quiet" -XX:+PrintCompilation -XX:-LogVMOutput'
else
if [ "$1" == "safepoint" ]; then
export _JAVA_OPTIONS='-Xbatch -Xlog:gc -XX:+UseSerialGC -XX:-UseOnStackReplacement -XX:-TieredCompilation -XX:CICompilerCount=1 -XX:LoopUnrollLimit=0 -Djava.library.path=../cpp/ -XX:CompileCommand="quiet" -XX:-LogVMOutput'
else
if [ "$1" == "null_check_bench" ]; then
export CLASSPATH=../dist/benchmarks.jar
export _JAVA_OPTIONS='-Xbatch -XX:+UseSerialGC -XX:-UseOnStackReplacement -XX:-TieredCompilation -XX:CICompilerCount=1 -XX:LoopUnrollLimit=0 -XX:-LogVMOutput'
else
if [ "$1" == "arraybounds_check" ]; then
export _JAVA_OPTIONS='-Xbatch -XX:-UseCompressedOops -XX:+UseSerialGC -XX:-UseOnStackReplacement -XX:-TieredCompilation -XX:CICompilerCount=1 -XX:LoopUnrollLimit=0 -XX:CompileCommand="quiet" -XX:-LogVMOutput'
fi
fi
fi
fi
fi
fi

#export LD_LIBRARY_PATH=/share/OpenJDK/hsdis

alias javac=/share/output-jdk9-hs-comp-opt/images/jdk/bin/javac

mkdir -p /c/Users/D046063/public_html/hotspot/GeekOut2017/git/examples/_$1
cd /c/Users/D046063/public_html/hotspot/GeekOut2017/git/examples/_$1

set -o history
unset HISTFILE
history -c
history -r ../.history_$1
