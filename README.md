# MyDialog
首先创建一个 library ，通过 File -> New -> New Module ，选择 library

或者将原项目的 build.gradle 内的

```
apply plugin: 'com.android.application'

```
修改成
```
apply plugin: 'com.android.library'
```
根目录的 build.gradle 加入 maven-plugin
```
    dependencies {
        classpath 'com.android.tools.build:gradle:2.3.3'
        classpath 'com.github.dcendents:android-maven-gradle-plugin:1.4.1'
    }
```

