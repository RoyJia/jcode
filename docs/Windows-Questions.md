---
title: Delete Lang Name files on Windows
tag: Tools, Windows
date: 2018-05-03
---

Windows删除文件
---

> 以下操作均在命令窗口中操作

1.  创建一个目录，随意起名，例如：`mkdir deleteLongFilesDir`
2.  假设这个目录下的文件没法直接删除 `D:\Development\Liferay\themes`
3.  使用 `robocopy` 关联上述目录：`robocopy D:\deleteLongFilesDir D:\Development\Liferay\themes /purge`
4.  使用 `rmdir` 删除 `deleteLongFilesDir`。（`rmdir deleteLongFilesDir`）
5.  `deleteLongFilesDir` 被删除了，同样 `D:\Development\Liferay\themes` 下的所有东西也被删掉了。

Reference Link
---

[https://stackoverflow.com/questions/44081985/how-to-delete-the-file-name-is-too-long-in-windows-command-prompt](https://stackoverflow.com/questions/44081985/how-to-delete-the-file-name-is-too-long-in-windows-command-prompt)