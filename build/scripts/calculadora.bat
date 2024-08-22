@rem
@rem Copyright 2015 the original author or authors.
@rem
@rem Licensed under the Apache License, Version 2.0 (the "License");
@rem you may not use this file except in compliance with the License.
@rem You may obtain a copy of the License at
@rem
@rem      https://www.apache.org/licenses/LICENSE-2.0
@rem
@rem Unless required by applicable law or agreed to in writing, software
@rem distributed under the License is distributed on an "AS IS" BASIS,
@rem WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
@rem See the License for the specific language governing permissions and
@rem limitations under the License.
@rem

@if "%DEBUG%"=="" @echo off
@rem ##########################################################################
@rem
@rem  calculadora startup script for Windows
@rem
@rem ##########################################################################

@rem Set local scope for the variables with windows NT shell
if "%OS%"=="Windows_NT" setlocal

set DIRNAME=%~dp0
if "%DIRNAME%"=="" set DIRNAME=.
set APP_BASE_NAME=%~n0
set APP_HOME=%DIRNAME%..

@rem Resolve any "." and ".." in APP_HOME to make it shorter.
for %%i in ("%APP_HOME%") do set APP_HOME=%%~fi

@rem Add default JVM options here. You can also use JAVA_OPTS and CALCULADORA_OPTS to pass JVM options to this script.
set DEFAULT_JVM_OPTS=

@rem Find java.exe
if defined JAVA_HOME goto findJavaFromJavaHome

set JAVA_EXE=java.exe
%JAVA_EXE% -version >NUL 2>&1
if %ERRORLEVEL% equ 0 goto execute

echo.
echo ERROR: JAVA_HOME is not set and no 'java' command could be found in your PATH.
echo.
echo Please set the JAVA_HOME variable in your environment to match the
echo location of your Java installation.

goto fail

:findJavaFromJavaHome
set JAVA_HOME=%JAVA_HOME:"=%
set JAVA_EXE=%JAVA_HOME%/bin/java.exe

if exist "%JAVA_EXE%" goto execute

echo.
echo ERROR: JAVA_HOME is set to an invalid directory: %JAVA_HOME%
echo.
echo Please set the JAVA_HOME variable in your environment to match the
echo location of your Java installation.

goto fail

:execute
@rem Setup the command line

set CLASSPATH=%APP_HOME%\lib\calculadora-1.0-SNAPSHOT.jar;%APP_HOME%\lib\desktop-jvm-1.5.0.jar;%APP_HOME%\lib\skiko-awt-runtime-windows-x64-0.7.77.jar;%APP_HOME%\lib\material-desktop-1.5.0.jar;%APP_HOME%\lib\material-ripple-desktop-1.5.0.jar;%APP_HOME%\lib\foundation-desktop-1.5.0.jar;%APP_HOME%\lib\animation-desktop-1.5.0.jar;%APP_HOME%\lib\foundation-layout-desktop-1.5.0.jar;%APP_HOME%\lib\animation-core-desktop-1.5.0.jar;%APP_HOME%\lib\material-icons-core-desktop-1.5.0.jar;%APP_HOME%\lib\ui-desktop-1.5.0.jar;%APP_HOME%\lib\ui-text-desktop-1.5.0.jar;%APP_HOME%\lib\ui-graphics-desktop-1.5.0.jar;%APP_HOME%\lib\skiko-awt-0.7.77.jar;%APP_HOME%\lib\ui-tooling-preview-desktop-1.5.0.jar;%APP_HOME%\lib\runtime-saveable-desktop-1.5.0.jar;%APP_HOME%\lib\ui-unit-desktop-1.5.0.jar;%APP_HOME%\lib\ui-geometry-desktop-1.5.0.jar;%APP_HOME%\lib\runtime-desktop-1.5.0.jar;%APP_HOME%\lib\kotlinx-coroutines-core-jvm-1.6.4.jar;%APP_HOME%\lib\kotlin-stdlib-jdk8-1.8.21.jar;%APP_HOME%\lib\kotlin-stdlib-jdk7-1.8.21.jar;%APP_HOME%\lib\ui-util-desktop-1.5.0.jar;%APP_HOME%\lib\atomicfu-jvm-0.17.0.jar;%APP_HOME%\lib\kotlin-stdlib-1.8.21.jar;%APP_HOME%\lib\kotlin-stdlib-common-1.8.21.jar;%APP_HOME%\lib\annotations-13.0.jar


@rem Execute calculadora
"%JAVA_EXE%" %DEFAULT_JVM_OPTS% %JAVA_OPTS% %CALCULADORA_OPTS%  -classpath "%CLASSPATH%" MainKt %*

:end
@rem End local scope for the variables with windows NT shell
if %ERRORLEVEL% equ 0 goto mainEnd

:fail
rem Set variable CALCULADORA_EXIT_CONSOLE if you need the _script_ return code instead of
rem the _cmd.exe /c_ return code!
set EXIT_CODE=%ERRORLEVEL%
if %EXIT_CODE% equ 0 set EXIT_CODE=1
if not ""=="%CALCULADORA_EXIT_CONSOLE%" exit %EXIT_CODE%
exit /b %EXIT_CODE%

:mainEnd
if "%OS%"=="Windows_NT" endlocal

:omega
