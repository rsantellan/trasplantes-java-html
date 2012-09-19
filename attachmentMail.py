#!/usr/bin/python
import smtplib
from email.MIMEMultipart import MIMEMultipart
from email.MIMEBase import MIMEBase
from email.MIMEText import MIMEText
from email.Utils import COMMASPACE, formatdate
from email import Encoders
import os
 
def sendMail(to, fro, subject, text, files=[],server="localhost"):
    assert type(to)==list
    assert type(files)==list
 
 
    msg = MIMEMultipart()
    msg['From'] = fro
    msg['To'] = COMMASPACE.join(to)
    msg['Date'] = formatdate(localtime=True)
    msg['Subject'] = subject
 
    msg.attach( MIMEText(text) )
 
    for file in files:
        part = MIMEBase('application', "octet-stream")
        part.set_payload( open(file,"rb").read() )
        Encoders.encode_base64(part)
        part.add_header('Content-Disposition', 'attachment; filename="%s"'
                       % os.path.basename(file))
        msg.attach(part)
 
    smtp = smtplib.SMTP(server)
    smtp.sendmail(fro, to, msg.as_string() )
    smtp.close()


#import os
path="/home/backups/db/daily/transplantehtml"  # insert the path to the directory of interest here
dirList=os.listdir(path)
#for fname in dirList:
    #print fname

max_mtime = 0
for dirname,subdirs,files in os.walk(path):
    for fname in files:
        full_path = os.path.join(dirname, fname)
        mtime = os.stat(full_path).st_mtime
        if mtime > max_mtime:
            max_mtime = mtime
            max_dir = dirname
            max_file = fname

#print max_dir, max_file
sending_file = max_dir + "/" + max_file;
#print sending_file

import datetime

now = datetime.datetime.now()
 
# Example:
sendMail(['Rodrigo <rsantellan@gmail.com>'],'Admin <root@localhost>','Backup de base ' + str(now),'Este es el backup de la base.',[sending_file])

