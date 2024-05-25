# ChatGPT TTS backend

This is a Java Spring Boot project that uses the OpenAI API to generate responses to user messages, which are then converted to speech by a tts server.

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
Send a POST request to the server with the text you want to convert to speec

curl -X POST -H "Content-Type: application/json" -d "{\"text\":\"how to boil eggs\"}" http://localhost:8080/tts

The text you send in the POST request will be sent to the OpenAI API, which will generate a response. This response will then be converted to speech by the tts server.  The speech will be saved as a test.wav file in the project root directory for now.  Enjoy!

## Next steps
Improve the integration with the OpenAI API for response generation
Integrate with the messenger of choice to send voiced responses