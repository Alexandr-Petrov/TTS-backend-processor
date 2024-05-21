# How to run it

1. Clone the repository
2. Run the tts server with docker:
```bash
docker run -it -p 5002:5002 synesthesiam/mozilla-tts
```
3. Run the project
4. Send a POST request to the server with the text you want to convert to speech
```bash
curl -X POST -H "Content-Type: application/json" -d "{\"text\":\"Daniel has a truly unique personality\"}" http://localhost:8080/tts
```

Speech would be saved as a test.wav file in the project root directory for now.

Enjoy!

Next steps:

1. add integration with chatgpt for response generation
2. integrate with the messenger of choice to send voiced responses