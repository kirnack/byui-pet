#
# Generated Makefile - do not edit!
#
# Edit the Makefile in the project folder instead (../Makefile). Each target
# has a -pre and a -post target defined where you can add customized code.
#
# This makefile implements configuration specific macros and targets.


# Environment
MKDIR=mkdir
CP=cp
GREP=grep
NM=nm
CCADMIN=CCadmin
RANLIB=ranlib
CC=gcc
CCC=g++
CXX=g++
FC=gfortran
AS=as

# Macros
CND_PLATFORM=GNU-MacOSX
CND_CONF=Debug
CND_DISTDIR=dist
CND_BUILDDIR=build

# Include project Makefile
include Makefile

# Object Directory
OBJECTDIR=${CND_BUILDDIR}/${CND_CONF}/${CND_PLATFORM}

# Object Files
OBJECTFILES= \
	${OBJECTDIR}/JNIFileCamera.o \
	${OBJECTDIR}/nativeJNICamera.o


# C Compiler Flags
CFLAGS=

# CC Compiler Flags
CCFLAGS=
CXXFLAGS=

# Fortran Compiler Flags
FFLAGS=

# Assembler Flags
ASFLAGS=

# Link Libraries and Options
LDLIBSOPTIONS=-L../PET/src/edu/byui/PET/camera/jnilibs

# Build Targets
.build-conf: ${BUILD_SUBPROJECTS}
	"${MAKE}"  -f nbproject/Makefile-${CND_CONF}.mk ${CND_DISTDIR}/${CND_CONF}/${CND_PLATFORM}/libJNICamera.dylib

${CND_DISTDIR}/${CND_CONF}/${CND_PLATFORM}/libJNICamera.dylib: ${OBJECTFILES}
	${MKDIR} -p ${CND_DISTDIR}/${CND_CONF}/${CND_PLATFORM}
	${LINK.cc} -dynamiclib -install_name libJNICamera.dylib -o ${CND_DISTDIR}/${CND_CONF}/${CND_PLATFORM}/libJNICamera.dylib -fPIC ${OBJECTFILES} ${LDLIBSOPTIONS} 

${OBJECTDIR}/JNIFileCamera.o: JNIFileCamera.cpp 
	${MKDIR} -p ${OBJECTDIR}
	${RM} $@.d
	$(COMPILE.cc) -g -I/System/Library/Frameworks/JavaVM.framework/Headers -I/System/Library/Java/JavaVirtualMachines/1.6.0.jdk/Contents/Home/lib -I../PET/src/edu/byui/PET/camera -fPIC  -MMD -MP -MF $@.d -o ${OBJECTDIR}/JNIFileCamera.o JNIFileCamera.cpp

${OBJECTDIR}/nativeJNICamera.o: nativeJNICamera.cpp 
	${MKDIR} -p ${OBJECTDIR}
	${RM} $@.d
	$(COMPILE.cc) -g -I/System/Library/Frameworks/JavaVM.framework/Headers -I/System/Library/Java/JavaVirtualMachines/1.6.0.jdk/Contents/Home/lib -I../PET/src/edu/byui/PET/camera -fPIC  -MMD -MP -MF $@.d -o ${OBJECTDIR}/nativeJNICamera.o nativeJNICamera.cpp

# Subprojects
.build-subprojects:

# Clean Targets
.clean-conf: ${CLEAN_SUBPROJECTS}
	${RM} -r ${CND_BUILDDIR}/${CND_CONF}
	${RM} ${CND_DISTDIR}/${CND_CONF}/${CND_PLATFORM}/libJNICamera.dylib

# Subprojects
.clean-subprojects:

# Enable dependency checking
.dep.inc: .depcheck-impl

include .dep.inc
