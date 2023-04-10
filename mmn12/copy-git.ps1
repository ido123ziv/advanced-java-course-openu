# copy and git
Param (
  [Parameter(Mandatory)]$Path,
  $Message
)
Copy-Item $Path -Destination "q2-bigint\"
$FileName=$Path.split("\")[2]
Write-Host "File created at path q2-bigint\$FileName"
git add q2-bigint\$FileName
If (-Not $Message -eq '') {
    git commit -m "Adding $Message function"
} Else {
    git commit -m "Adding $FileName"
}
