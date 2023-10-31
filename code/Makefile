.PHONY: cpp_build

cpp_init:
	mkdir -p output
	cmake --log-level=DEBUG -G "Unix Makefiles" -DCMAKE_BUILD_TYPE=Debug -DCMAKE_CXX_FLAGS="-pthread" -DCPP_VERSION="17" -S . -B output
cpp_build: cpp_init
	cmake --build output --config Debug  -- -j12