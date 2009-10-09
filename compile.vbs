MsgBox("Press Ok and wait until there is a DONE message.")
CreateObject("Wscript.Shell").Run("nmake all"),0, TRUE
MsgBox("DONE Message...")