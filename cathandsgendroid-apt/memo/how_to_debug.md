## How to debug

### Main class
com.sun.tools.javac.Main

### Classpath
/usr/lib/jvm/java-8-openjdk-amd64/lib/tools.jar

### Program argments
-processor net.cattaka.util.cathandsgendroid.apt.CatHandsGendroidProcessor -s build/java -d build/classes -sourcepath src/test/java/ src/test/java/net/cattaka/util/cathandsgendroid/test/model/FullModel.java
