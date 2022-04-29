from socket import *
serverPort = 5555
s = socket(AF_INET, SOCK_DGRAM)
s.bind(('', serverPort))
print("The server is ready.")
while True:
    message, clientAddress = s.recvfrom(2040)
    print("The message is received: ", message)
    modifiedMessage = message.decode().upper()
    print("This message is sent: ", modifiedMessage)
    s.sendto(modifiedMessage.encode(), clientAddress)