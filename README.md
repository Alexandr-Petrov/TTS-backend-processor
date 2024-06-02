# ChatGPT TTS backend

This is a Java Spring Boot project that uses the OpenAI API to generate responses to user messages, which are then converted to speech by a tts server and returned to the user as an audio file.
The project is a backend service that can be integrated with any chatbot to provide voice responses to user messages.

## How to run it

1. Clone the repository
2. Set up your environment variables in a `.env` file in the root directory of the project. You will need to set the `OPENAI_API_KEY` variable. Here's an example of what your `.env` file should look like:

```dotenv
OPENAI_API_KEY=your_openai_api_key
```

Run the tts server with docker:
```bash
docker run -it -p 5002:5002 synesthesiam/mozilla-tts
```

Run the project

Send a POST request to the server with the text you want to convert to speech. Here's an example using curl:

```bash
curl -X POST -H "Content-Type: application/json" -d "{\"text\":\"how to boil eggs\"}" http://localhost:8080/tts
```
The text you send in the POST request will be sent to the OpenAI API, which will generate a response. This response will then be converted to speech by the tts server.  The speech file would be returned by the request and could be saved locally.  Enjoy!

## Next steps
Integrate with the messenger of choice to send voiced responses