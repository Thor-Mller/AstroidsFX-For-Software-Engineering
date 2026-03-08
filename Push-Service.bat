@echo off
git add .
set /p msg="Indtast commit-besked: "
git commit -m "%msg%"
git push
pause