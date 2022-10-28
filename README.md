# YGO Scanner Backend

Sadly, the ocr delivers not the wished output. 
The text output ist not usable to get the serial number.

## TODO
1. Try different ocr library
2. Train ocr
3. How to crop image correctly

## Build

### Locally
1. Install tesseract
2. Install java19
3. Run the main class (Intellij: Use Run Configuration)

### Docker
1. mvn package
2. docker-compose up -d --build