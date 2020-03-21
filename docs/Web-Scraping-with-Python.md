---
title: What I get from Web Scraping with Python
tag: Python
date: 2018-09-02
---

### 55% of the content on the Internet is still in English

[https://w3techs.com/technologies/overview/content\_language/all](https://w3techs.com/technologies/overview/content_language/all)

### [Six degrees of separation](https://en.wikipedia.org/wiki/Six_degrees_of_separation) - is the idea that all living things and everything else in the world are six or fewer steps away from each other so that a chain of “a friend of a friend” statements can be made to connect any two people in a maximum of six steps.

I can find a movie that has Iron Man(Robert Downey Jr.) and Tom Cruise by this website [http://oracleofbacon.org/index.php](http://oracleofbacon.org/index.php)

### UTF-8 - Universal Character Set - Transformation Format 8 bit

I thought that UTF-8 stores all characters as 8 bits. In fact, “8-bit” is just the minimum number of digits required to display a character, not the maximum number of digits.

### n-gram is a contiguous sequence of n items from a given sample of text or speech.

In nature language analysis, n-gram can help to find common phrase

```python
    from urllib.request import urlopen
    from bs4 import BeautifulSoup

    def ngrams(input, n):
      input = input.split(' ')
      output = []
      for i in range(len(input)-n+1):
        output.append(input[i:i+n])
      return output

    html = urlopen("http://en.wikipedia.org/wiki/Python_(programming_language)")
    bsObj = BeautifulSoup(html)
    content = bsObj.find("div", {"id":"mw-content-text"}).get_text()
    ngrams = ngrams(content, 2)
    print(ngrams)
    print("2-grams count is: "+str(len(ngrams)))
```

### [OpenRefine](http://openrefine.org/) is a tool for working with messy data

OpenRefine is an open source software released by Metaweb in 2009.

Google acquired Metaweb in 2010 and changed the name of the project from Freebase Gridworks to Google Refine. In 2012, Google gave up support for Refine and turned it back into open source software, changing its name to OpenRefine.

### Python Regular Expression

| 符号 | 含义 | 例子 | 匹配结果 |
| :---- | :--- | :--- | :--- |
| `*` | `*` `匹配前面的字符、子表达式或括号里的字符 0 次或多次` | `a*b*` | `aaaaaaaa，aaabbbbb，bbbbbb` |
| `+` | `匹配前面的字符、子表达式或括号里的字符至少 1 次` | `a+b+` | `aaaaaaab，aaabbbbb，abbbbbb` |
| `[]` | `匹配任意一个字符（相当于“任选一个”）` | `[A-Z]*` | `APPLE，CAPITALS，QWERTY` |
| `()` | `表达式编组（在正则表达式的规则里编组会优先运行）` | `(a*b)*` | `aaabaab，abaaab，ababaaaaab` |
| `{m,n}` | `匹配前面的字符、子表达式或括号里的字符 m 到 n 次（包含 m 或 n）` | `a{2,3}b{2,3}` | `aabbb，aaabbb，aabb` |
| `[^]` | `匹配任意一个不在中括号里的字符` | `[^A-Z]*` | `apple，lowercase，qwerty` |
| `.` | `匹配任意单个字符（包括符号、数字和空格等）` | `b.d` | `bad，bzd，b$d，b d` |
| `^` | `指字符串开始位置的字符或子表达式` | `^a` | `apple，asdf，a` |
| `$` | `经常用在正则表达式的末尾，表示“从字符串的末端匹配”。如果不用它，每个正则表达式实际都带着“.\*”模式，只会从字符串开头进行匹配。这个符号可以看成是 ^ 符号的反义词` | `[A-Z]*[a-z]*$` | `ABCabc，zzzyx，Bob` |
| `?!` | `“不包含”。这个奇怪的组合通常放在字符或正则表达式前面，表示字符不能出现在目标字符串里. 这个符号比较难用，字符通常会在字符串的不同部位出现。如果要在整个字符串中全部排除某个字符，就加上 ^ 和 $ 符号` | `^((?![A-Z]).)*$` | `no-caps-here，$ymb0ls a4e f!ne` |