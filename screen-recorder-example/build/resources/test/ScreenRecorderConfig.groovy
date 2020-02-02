import org.monte.media.Format
import org.monte.media.FormatKeys
import org.monte.media.math.Rational
import java.awt.GraphicsEnvironment
import static org.monte.media.FormatKeys.EncodingKey
import static org.monte.media.FormatKeys.FrameRateKey
import static org.monte.media.FormatKeys.KeyFrameIntervalKey
import static org.monte.media.FormatKeys.MIME_AVI
import static org.monte.media.FormatKeys.MIME_MP4
import static org.monte.media.FormatKeys.MediaTypeKey
import static org.monte.media.FormatKeys.MimeTypeKey
import static org.monte.media.VideoFormatKeys.CompressorNameKey
import static org.monte.media.VideoFormatKeys.DepthKey
import static org.monte.media.VideoFormatKeys.ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE
import static org.monte.media.VideoFormatKeys.QualityKey

// This recorder is mandatory to exist. It holds the default values for all screen recorder properties
defaultRecorder {}

// You can define custom recorders by using some/all of the below properties
// The omitted properties will take default values.
myCustomRecorder {
    graphicsConfiguration = GraphicsEnvironment
            .localGraphicsEnvironment
            .defaultScreenDevice
            .defaultConfiguration
    captureArea = graphicsConfiguration.bounds
    fileFormat = new Format(MediaTypeKey, FormatKeys.MediaType.FILE, MimeTypeKey, MIME_AVI)
    screenFormat = new Format(
            MediaTypeKey, FormatKeys.MediaType.VIDEO, EncodingKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE,
            CompressorNameKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE,
            DepthKey, 24, FrameRateKey, Rational.valueOf(15),
            QualityKey, 1.0f,
            KeyFrameIntervalKey, 15 * 60)
    mouseFormat = new Format(MediaTypeKey, FormatKeys.MediaType.VIDEO, EncodingKey, "black", FrameRateKey, Rational.valueOf(30))
    audioFormat = null
    pathToMovieFolder = 'build/videoFolder'
}
