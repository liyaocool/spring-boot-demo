
# Jasypt加密插件的使用

## (注意)bat文件需要jasypt.xx.jar同级文件夹

## 若cmd窗口中文乱码

搜索打开 regedit 修改如下注册表 utf-8字符集即可

    [HKEY_LOCAL_MACHINE\SOFTWARE\Microsoft\Command Processor]，新建一个字符串值，key-value如下：
    "autorun"="chcp 65001"，之后重新打开cmd即可。
## 加密原文  
    ENC(xxxx)
## 命令行输入密钥来解密
    java -jar xxx.jar --jasypt.encryptor.password=xxx &;