reset
(gradle -q clean ; rm -fr .gradle)
echo 'int main() {
        skip;
        pyramid(20,49)
      }

      int pyramid(int nn, int tmp) {
        tmp := 0;
        repeat { tmp := (tmp + (nn * nn)); nn := (nn - 1) } until (nn < 0);
        tmp
      }' | gradle -q :task1:run | gradle -q :task2:run | gradle -q :task3:run
