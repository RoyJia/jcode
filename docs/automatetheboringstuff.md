---
title: What I get from automatetheboringstuff
tag: Python
date: 2018-09-04
---

> Don’t Debug with `print()`

**Log messages are intended for the programmer, not the user.** The user won’t care about the contents of some dictionary value you need to see to help with debugging; use a log message for something like that. For messages that the user will want to see, like File not found or Invalid input, please enter a number, you should use a print() call. You don’t want to deprive the user of useful information after you’ve disabled log messages.

<!-- More -->

> traceback - if you dont want your program be crashed

instead of crashing your program right when an exception occurs, you can write the traceback information to a log file and keep your program running. You can look at the log file later, when you’re ready to debug your program. Enter the following into the interactive shell:

```python
    import traceback

    try:
        raise Exception('This is the error message.')
    except:
        errorFile = open('errorInfo.txt', 'w')
        errorFile.write(traceback.format_exc())
        errorFile.close()
        print('The traceback info was written to errorInfo.txt.')
```

> `urllib2` VS `requests`

- `urllib2` is python’s built-in lib, `requests` is third-party module
- `urllib2` is too complicated to use

> check HTML source

I will need to look at HTML source of the web pages that my programs will work with. To do this, **right click** or (**ctrl-click** on OS X) any web page in my web browser, and select View Source or View Page Source to see the HTML text of the page.

Opening my browser’s develop tools - In OS X, pressing **CMD-OPTION-I** will open Chrome’s develop tool

> Locating a specific piece of HTML in a string with regular expressions.

Locating a specific piece of HTML in a string seems like a perfect case for regular expressions. But it would not be recommanded, see [here](https://stackoverflow.com/questions/1732348/regex-match-open-tags-except-xhtml-self-contained-tags/1732454#1732454)

> Keeping Time, Scheduling Tasks, and Launching Programs

The Unix epoch (January 1, 1970, at midnight, UTC) is a standard reference time for many programming languages, including Python. While the time.time() function module returns an epoch timestamp (that is, a float value of the number of seconds since the Unix epoch), the datetime module is better for performing date arithmetic and formatting or parsing strings with date information.

The threading module is used to create multiple threads, which is useful when you need to download multiple files or do other tasks simultaneously. But make sure the thread reads and writes only local variables, or you might run into concurrency issues.

Python programs can launch other applications with the subprocess.Popen() function. Command line arguments can be passed to the Popen() call to open specific documents with the application.

> Shirt Color Trick

Pick a color besides black, grey, or blue and find the closest person wearing a shirt of that color. Go up and talk to them, no matter who they are. So if you pick green, find the closest person in a green shirt. If there’s nobody wearing a green shirt, pick a new color. Picking an uncommon color limits your choice of people to talk to, which limits how much your bias can influence you.

> SMS server - [https://www.twilio.com/](https://www.twilio.com/)

> Manipulating Images

Enter Python. **Pillow** is a third-party Python module for interacting with image files. The module has several functions that make it easy to crop, resize, and edit the content of an image.