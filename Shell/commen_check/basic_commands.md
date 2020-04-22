# Basic shell comands practice

## Questions

> To find files which the file name contains `list`

`find . -name "*list*"`

> To combine 2 text files(1.txt, 2.txt) lines by lines to 3.txt

`paste 1.txt 2.txt > 3.txt`
`paste -d" " 1.txt 2.txt > 3.txt`

> To check file, if exist then remove

`[ -f file.txt ] && rm file.txt`
