from socket import *
serverPort = 7777
s = socket(AF_INET, SOCK_STREAM)
s.bind(('', serverPort))
s.listen(1)
print("The server is ready.")
while True:
    cs, addr = s.accept()
    print("The client name and port", addr)
    message = cs.recv(1024).decode()
    print("The message received: ", message)
    modifiedMessage = message.upper()
    print("The message sent: ", modifiedMessage)
    cs.send(modifiedMessage.encode())
    cs.close()


