[![](https://jitpack.io/v/look0089/MyDialog.svg)](https://jitpack.io/#look0089/MyDialog)
# MyDialog
1. 创建一个 library
通过 File -> New -> New Module ，选择 library

或者将原项目的 build.gradle 内的 apply (一般在第一行)

```
apply plugin: 'com.android.application'
```
修改成
```
apply plugin: 'com.android.library'
```
这样就能创建一个 Module

2. 添加 maven 依赖
根目录的 build.gradle 加入 maven-plugin
```
    dependencies {
        classpath 'com.android.tools.build:gradle:2.3.3'
        classpath 'com.github.dcendents:android-maven-gradle-plugin:1.4.1'
    }
```

项目的 build.gradle 添加
```
apply plugin: 'com.android.library'
apply plugin: 'com.github.dcendents.android-maven'
```

3. 将 library 上传到 github，并提交 release

4. 打开 https://jitpack.io/ 并将 github 的项目地址填入，点击 Look Up
会看到刚刚提交的 release 的版本号在列表中

5.点击 get it 后，就可以在你的项目内添加依赖使用了
使用只需要2个步骤:
- 在需要使用的项目根目录添加
```
	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```
- 在项目添加依赖（以本项目为例）
```
	dependencies {
	        compile 'com.github.look0089:MyDialog:v1.7'
	}
```

6.可以页面下复制标签，用于在 github 中显示 jitpack 版本信息
[![](https://jitpack.io/v/look0089/MyDialog.svg)](https://jitpack.io/#look0089/MyDialog)

