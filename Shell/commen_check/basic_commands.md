# Basic shell comands practice

## Questions

> To find files which the file name contains `list`

`find . -name "*list*"`

> To combine 2 text files(1.txt, 2.txt) lines by lines to 3.txt

`paste 1.txt 2.txt > 3.txt`
`paste -d" " 1.txt 2.txt > 3.txt`

> To check file, if exist then remove

`[ -f file.txt ] && rm file.txt`

> To replace sub part of string

```bash
aaa="aa,bb,cc"
pattern="|"
result=${aaa//,/$pattern}

echo $result
```

> To split one line to multiple lines

```bash
echo -e "11,22,33" | awk '{split($0,a,","); for (i in a) print a[i];}' >> output.txt
```

- [Awk Text Split and Delimit Examples](https://www.poftut.com/awk-text-split-delimit-examples/)
- [Comma separated words to next line in new file](https://unix.stackexchange.com/questions/159577/comma-separated-words-to-next-line-in-new-file)

> To ignore / skip first line or header while reading  a file in bash

```bash
sed 1d $filename | while IFS=, read -r accountId ProductId Product
do
    echo "Account $accountId has productId $ProductId and product $Product"
done
```
