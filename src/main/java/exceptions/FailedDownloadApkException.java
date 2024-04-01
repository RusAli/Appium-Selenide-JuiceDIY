package exceptions;

public class FailedDownloadApkException extends RuntimeException {

  public FailedDownloadApkException() {
    super("Failed to download apk");
  }


}
