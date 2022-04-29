from socket import *
serverName = '127.0.0.1'
serverPort = 7777

s = socket(AF_INET, SOCK_STREAM)
s.connect((serverName, serverPort))
message = input("Enter lowercase message: ")
s.send(message.encode())
modifiedMessage = s.recv(1024)
print(modifiedMessage.decode())
s.close()