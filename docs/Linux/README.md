### 常用linux命令
* grep命令：查询文本，匹配目标字符串所在的行
    * grep -C 5 key text.txt: 输出包含key的行数上下五行
    * grep -B 5 key text.txt: 输出包含key的行数下五行
    * grep -A 5 key text.txt: 输出包含key的行数上五行
    * egrep :支持正则匹配 egrep "155.{1,5}55" test.txt
* ps -ef|grep :查进程
* df -h /:查看磁盘使用情况
* free：查看内存使用情况
* find ./ -name test*：查看当前目录以test开头的文件或者目录
* netstat -tunlp|grep ：查看端口占用情况
* vim:V可视化模式，gg光标到首行，G到尾行
* | 表示管道符：作用是把前面的 stdout 输出当作下一个命令的 stdin 数据