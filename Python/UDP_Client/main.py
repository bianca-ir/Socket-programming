from socket import *

serverName = '127.0.0.1'
serverPort = 5555
s = socket(AF_INET, SOCK_DGRAM)
message = input("Enter a lowercase sentence: ")
s.sendto(message.encode(), (serverName, serverPort))
modifiedMessage, serverAddress = s.recvfrom(2048)
print("These are the client name and port: ", serverAddress)
print(modifiedMessage.decode())
s.close()


