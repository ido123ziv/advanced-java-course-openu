# copy and git
Param (
  $Path
)
Copy-Item $Path -Destination "q1-alarms\"
$FileName=$Path.split("\")[2]
Write-Host "File created at path q1-alarms\$FileName"
git add q1-alarms\$FileName
git commit -m "Adding $FileName"