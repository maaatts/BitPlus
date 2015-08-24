# Bit+

### Project Goals
Wrapper for 8BitMMO to allow users to write their own scripts and extensions to the game.

### Build Guide
1. Clone the source tree into an Eclipse workspace
2. [Download the latest 8BitMMO jar](https://themallard.me/bitmmo/cleans/) and save it as
`resources/HTMudWeb_latest.jar`. Edit `me.themallard.bitmmo.impl.BitRevisionHelper` and
make sure that `getLatestRevision` returns the right number.
3. Run `Bitmmo.class`.

### Reporting Issues
If you think you've found a bug in the code, file a GitHub issue. Make sure to include all of the changes
you've made to the code (if any).

### Credits
* [@maaatts](https://github.com/maaatts)
* [@TheBiblMan](https://github.com/TheBiblMan) - being bibl
* [@Konloch](https://github.com/konloch) - moral support
* [ObjectWeb ASM](http://asm.ow2.org/)
