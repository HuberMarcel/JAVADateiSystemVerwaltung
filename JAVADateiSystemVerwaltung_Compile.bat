cd src
javac -d ..\build\classes de\marcelhuber\javase7dateisystemverwaltung\JAVALaufwerksbelegungsErmittler.java
jar -cvfm .\..\dist\JAVADateiSystemVerwaltung.jar .\..\myManifest.mf ..\build\classes
rem [pause]
cmd
