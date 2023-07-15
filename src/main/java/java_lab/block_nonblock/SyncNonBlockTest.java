package java_lab.block_nonblock;

public class SyncNonBlockTest {
    static class 파일다운 implements Runnable {
        @Override
        public void run() {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // 비동기로 실행할 작업
            System.out.println("파일 다운로드 완료!");
        }
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new 파일다운());

        // 스레드 실행. 동기 - 논블로킹
        thread.start();

        // 논블로킹이므로 다른 작업 계속 가능
        System.out.println("파일 다운로드 시작");

        // 동기를 위해 스레드의 작업 완료 여부 확인
        int count = 1;
        while (thread.isAlive()) {
            System.out.println("파일 다운로드 중입니다..." + count);
            count ++;
        }
        System.out.println("파일 다운 끝!");

        System.out.println("다른거 해!");
    }
}
