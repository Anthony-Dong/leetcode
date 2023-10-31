cmake_minimum_required ( VERSION 3.11 )
project ( cpp_code )
message ( CMAKE_VERSION: ${CMAKE_VERSION} )

if (CPP_VERSION STREQUAL 20 OR NOT DEFINED CPP_VERSION)
  set ( CPP_VERSION 20 )
  set ( CMAKE_CXX_STANDARD 20 )
  message ( "build c++20" )
else ()
  set ( CMAKE_CXX_STANDARD 17 )
  message ( "build c++17" )
endif ()
set ( CMAKE_CXX_STANDARD_REQUIRED ON )

file (
    GLOB_RECURSE mains RELATIVE "${CMAKE_CURRENT_SOURCE_DIR}"
    "${CMAKE_CURRENT_SOURCE_DIR}/*/*/*solution.cpp"
)

foreach (mainfile IN LISTS mains)
  get_filename_component ( mainname ${mainfile} NAME_WE )
  get_filename_component ( path ${mainfile} PATH )
  string (REPLACE "/" "_" path ${path})
  add_executable ( ${PROJECT_NAME}_${path}_${mainname} ${mainfile} )
  target_link_libraries ( ${PROJECT_NAME}_${path}_${mainname} PUBLIC ${THIRD_PART_LIB} )
  message ( "add_executable : " ${PROJECT_NAME}_${path}_${mainname} ", main: " ${CMAKE_CURRENT_SOURCE_DIR}/${mainfile} )
endforeach ()