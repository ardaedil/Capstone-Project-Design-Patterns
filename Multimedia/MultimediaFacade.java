package Multimedia;

public class MultimediaFacade {
    private AudioProcessingSubsystem audioSubsystem;
    private VideoProcessingSubsystem videoSubsystem;
    private ImageProcessingSubsystem imageSubsystem;

    public MultimediaFacade() {
        this.audioSubsystem = new AudioProcessingSubsystem();
        this.videoSubsystem = new VideoProcessingSubsystem();
        this.imageSubsystem = new ImageProcessingSubsystem();
    }

    // Simplified methods for multimedia processing
    public void processAudio(String audioFile) {
        audioSubsystem.decodeAudio(audioFile);
        // Additional processing steps if needed
    }

    public void processVideo(String videoFile) {
        videoSubsystem.decodeVideo(videoFile);
        // Additional processing steps if needed
    }

    public void processImage(String imagePath) {
        imageSubsystem.resizeImage(imagePath, 800, 600);
        // Additional processing steps if needed
    }
}
