# Generic Engineering
Miscellaneous stuff for Immersive Engineering.

## Building
Put an appropriate deobf jar of IE into `lib` before the usual Forge workflow.

## Development
Normal Forge dev applies. To use the provided Log4j2 config, add something like this to your VM Arguments, replacing the
path as needed.

* Linux/Mac: `-Dlog4j.configurationFile=/home/yourname/dev/GenericEngineering/dev/log4j2.xml`
* Windows: `-Dlog4j.configurationFile=C:\Users\yournamehere\dev\GenericEngineering\dev\log4j2.xml`