#!/bin/bash
echo
echo 'Cleaning old builds... '
(gradle -q clean ; rm -fr .gradle)
echo 'Done.'
echo
echo '============================================'
echo
echo 'Building the project... '
(gradle -q build)
echo 'Done.'
echo
echo '============================================'
echo 'Now let us do some testing.'
echo ''
echo 'Input program 1:'
echo ''
echo ''
cat task2/01.sexp | gradle -q :task2:run
echo '============================================'
echo ''
echo 'Input program 2:'
echo ''
echo ''
cat task2/02.sexp | gradle -q :task2:run
echo '============================================'
echo ''
echo 'Input program 3:'
echo ''
echo ''
cat task2/03.sexp | gradle -q :task2:run
echo '============================================'
echo ''
echo 'Input program 4:'
echo ''
echo ''
cat task2/04.sexp | gradle -q :task2:run
echo '============================================'
echo ''
echo 'Input program 5:'
echo ''
echo ''
cat task2/05.sexp | gradle -q :task2:run
echo '============================================'
echo ''
echo 'Input program 6:'
echo ''
echo ''
cat task2/06.sexp | gradle -q :task2:run
echo '============================================'
echo ''
echo 'Input program 7:'
echo ''
echo ''
cat task2/07.sexp | gradle -q :task2:run
echo '============================================'
echo ''
echo 'Input program 8:'
echo ''
echo ''
cat task2/08.sexp | gradle -q :task2:run
echo '============================================'
echo ''
echo 'Input program 9:'
echo ''
echo ''
cat task2/09.sexp | gradle -q :task2:run
echo '============================================'
echo ''
echo 'Input program 10:'
echo ''
echo ''
cat task2/10.sexp | gradle -q :task2:run
echo '============================================'
echo ''
echo 'Input program 11:'
echo ''
echo ''
cat task2/11.sexp | gradle -q :task2:run
echo '============================================'
echo ''
echo 'Input program 12:'
echo ''
echo ''
cat task2/12.sexp | gradle -q :task2:run
echo '============================================'
echo ''
echo 'Input program 13:'
echo ''
echo ''
cat task2/13.sexp | gradle -q :task2:run
echo '============================================'
echo ''
echo 'Input program 14:'
echo ''
echo ''
cat task2/14.sexp | gradle -q :task2:run
echo '============================================'
echo ''
echo 'Input program 15:'
echo ''
echo ''
cat task2/15.sexp | gradle -q :task2:run
echo '============================================'
echo ''
echo 'Input program 16:'
echo ''
echo ''
cat task2/16.sexp | gradle -q :task2:run
echo '============================================'
echo ''
echo 'Input program 17:'
echo ''
echo ''
cat task2/17.sexp | gradle -q :task2:run
echo '============================================'
echo ''
echo 'Input program 18:'
echo ''
echo ''
cat task2/18.sexp | gradle -q :task2:run
echo '============================================'
echo ''
echo 'Input program 19:'
echo ''
echo ''
cat task2/19.sexp | gradle -q :task2:run
echo '============================================'
echo ''
echo 'Input program:'
echo ''
cat task2/20.sexp
echo ''
cat task2/20.sexp | gradle -q :task2:run
echo '============================================'
