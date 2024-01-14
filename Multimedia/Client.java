package Multimedia;

public class Client {
    public static void main(String[] args) {
        MultimediaFacade multimediaFacade = new MultimediaFacade();

        multimediaFacade.processAudio("audio.mp3");
        multimediaFacade.processVideo("video.mp4");
        multimediaFacade.processImage("image.jpg");
    }
}