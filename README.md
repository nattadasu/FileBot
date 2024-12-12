<!-- markdownlint-disable MD033 MD028 -->
# nattadasu's Personal Groovy Scripts for FileBot

Ready-to-use collection of Groovy scripts for FileBot to rename media files.

File format were optimized to be used alongside Anitomy-based parser (Taiga)
for Anime, while keeping it sane for other media library parsers to understand
as well.

## Post-Processing Scripts

### NFO generator for Episodes

This script will generate NFO file for each episode, containing metadata that
can be read by Kodi, Jellyfin, Emby, etc.

#### Requirements

* `curl` available on your path
* The Movie DB (TMDB) as source for metadata
* TMDB API key, obtain from [Settings](https://www.themoviedb.org/settings/api).

#### Configuration

Save following format to `~/.filebotsecrets.json`. DO NOT SHARE THIS FILE!

```json
{
  "tmdb_api": "your_tmdb_api_key",
  "language": "en-US",
  "person_info_dir": "/path/to/person_info/"
}
```

#### Usage for NFO Generator

> [!IMPORTANT]
>
> See [\[DOCS\] Custom Post-Processing Scripts](https://www.filebot.net/forums/viewtopic.php?t=13769)
> for official guide on how to use this script.

##### GUI

1. Open FileBot
2. Right click on "Rename" button
3. Click "Post Process" > a small button on right bottom of the dialog > "New Script"
4. Copy-past content from `post_xmbcnfo.groovy` to the script editor
5. Save the script

##### CLI

```sh
filebot --apply /path/to/post_xmbcnfo.groovy
```

Apply argument should be also executable on AMC script.

## File Formatting

Below is the guide if you want to use File Formatting feature on this repo.

### Disclaimer

For UNIX-Like user: This repo assumes your distro as Fedora Linux as the drive
mountpoint was hard-coded (`/run/media/<username>/<drive_name>`) rather usual
`/mnt/<drive_name>` that still being used by some distros. You can change
default behavior on `modules/filepath_posix.groovy`

### Editing

If you want to edit the scripts, keep in mind that the scripts are written in
favor of my personal preference, and might be not suitable for you.

However, the most important files were:

* `filepath.groovy` on modules folder are the scripts that handles
  <u>(default) drive logic</u>. By default, it tries to find the drive that have
  most free space, and if it's not found, it will use the default drive. You can
  override by changing `override` variable on the script.
* `common_` are shared scripts that does not have OS-specific behavior (drive
  logic, etc.), and only contains common logic to handle <u>file name</u>.

Additionally, there are some quality-of-life scripts that you can edit to enhance
your experience:

* `forceshowid_tv.groovy` to force write ID from TMDB to avoid incorrect ID
  detection on Jellyfin/Emby, etc when there are multiple shows with the same
  name (e.g. different years, anime vs live-action, etc.)
* `medianame.groovy` to handle media name, shortening it, etc. Useful when a
  fricking adapted-from-Light-Novel anime title is way too long, or making sure
  it has consistent naming (e.g. case sensitivity, stylization, etc.)
* `releasegroup.groovy` to handle additional release group when FileBot does not
  include it on its group index, or fixing it when it's incorrect.
* `releasesource.groovy` to handle additional release source when FileBot does
  not include it on its source index, or fixing it when it's incorrect.
* `season.groovy` to handle season name, additional information, etc.
* `r18_checker.groovy` to handle NSFW/LGBTQ+ tags, genres, etc. to be appended
  on the file name. You can modify the list on the script to include your own
  tags, or add ID of the title to be excluded from the list.
* `filespec.groovy` to add additional information to the file name, such as
  resolution, codec, etc., and especially CRC32 hash for verification and dupes
  handling when a release group uploads new version of the same episode.

You can refer to `compiled/` directory to check logics that FileBot will use.

### Usage for File Formatting

0. Clone this repository to your home directory (Windows: `%USERPROFILE%`,
   POSIX: `~`)
1. Modify the scripts, if needed
2. In your FileBot format configurator, import it with `@` notation.

> [!IMPORTANT]
>
> If you want to use the script on FileBot AMC and don't want to make your log
> file to be cluttered with script content, you can use `compiled/` directory
> since it already being minified to the most extent (<4K chars on compiled vs
> \>7K on `_*.groovy`).
>
> To use, replace `@FileBot/_tv.groovy` to `@FileBot/compiled/tv.groovy`,
> and so on.

#### TV Formatting

> [!IMPORTANT]
>
> This script only have been tested with The Movie DB (TMDB) as data source.

```groovy
@FileBot/_tv.groovy
```

#### Movie Formatting

> [!IMPORTANT]
>
> This script only have been tested with The Movie DB (TMDB) as data source.

```groovy
@FileBot/_movie.groovy
```

#### Music Formatting, for File Sharing

> [!NOTE]
>
> Commonly used for music sharing, where the music directory have different
> structure that usually contains information about the exact release media.

> [!WARNING]
>
> This script is not suitable for music library management, and currently
> unmaintained. Use it at your own risk.

```groovy
@FileBot/_music_shared.groovy
```

### Examples

#### TV, Common Example

Following example is a typical anime episode file, and what you can expect after
the script is applied in most case.

```yml
Before:
   Magilumiere.Magical.Girls.Inc.S01E10.Ginji.1080p.AMZN.WEB-DL.DDP2.0.H.264-VAR.mkv

After:
   /run/media/nattadasu/Videos/Videos/Anime/Magilumiere Magical Girls Inc/Season 1/[VAR] Magilumiere Magical Girls Inc - S01E10 - Ginji [AMZN.WEB-DL 1920x1080 AVC 8bit, EAC3 2.0, MSub (ENG JPN ARA DEU SPA ...)][F15F4F7B].mkv
```

#### TV, Less Optimal Example

From some release group that usually does not include source information, the
script will try to guess based on hardcoded rules written in `modules/releasesource.groovy`.

Additionally, when episode title is not available on remote database, it will
not include it on the file name to reduce clutter, usually due to episode is
relatively new. Plus, season name is included when it's available.

```yml
Before:
   [AAA] Sengoku Youko - 33 [1080p HEVC][A57E5CB3].mkv

After:
   /run/media/nattadasu/Videos/Videos/Anime/Sengoku Youko/Season 2 - The Thousandfold Chaos Arc/[AAA] Sengoku Youko - S02E20 [WEBRip 1920x1080 HEVC 10bit, AAC 2.0][A57E5CB3].mkv

```

#### TV, NSFW/LGBTQ+ Example

For some shows that marked as adult by TMDB, contains NSFW tags/genres or LGBTQ+
terms, the script will append additional information to the file name to make
it easier to filter out.

Note that most of the time, release source and group information on parent
directory won't be passed down to the episode file by default.

You can modify this behavior by editing `modules/r18_checker.groovy`.

Notice that the script will modify release source name to be descriptive on
2nd example. Behavior can be changed by editing `modules/releasesource.groovy`
where first item in the list will be used, and the rest will be used as known
synonyms.

```yml
Before:
   [DTA] Offering My Thing to a Gangster [Season 1] [WEB 1080p x265 HEVC AAC] [EngSubs] (Batch)/Offering My Thing to a Gangster - S01E03.mkv
After:
   /run/media/username/Videos/Videos/R18+ Anime/Offering My Thing to a Gangster/Season 1/Offering My Thing to a Gangster - S01E01 [1920x1080 HEVC 10bit, AAC 2.0][D168AC2B]

---

Before:
   No.Love.Zone.S01E01.1080p.LFTL.WEB-DL.KOR.AAC2.0.H.264.MSubs-TH.mkv
After:
   /run/media/username/Videos/Videos/R18+ Anime/No Love Zone/Season 1/[TH] No Love Zone - S01E01 [LAFTEL.WEB-DL 1920x1080 AVC 8bit, AAC 2.0, MSub (ENG ZHO IND MSA THA ...)][C3E810B5].mkv
```

#### Movie

Before:

```yml
Before:
   Suicide.Squad.2016.1080p.BluRay.DDP5.1.x265.10bit-Ginga.mkv
After:
   /run/media/username/Videos/Videos/Movies/Suicide Squad (2016) [tmdbid-297761]/[Ginga] Suicide Squad [BluRay 1920x1080 HEVC 10Bit, EAC3 DD 5.1][EF045D2F].mkv
```

#### Music

Assuming it has been properly tagged with MusicBrainz Picard or any advanced
tag editor previously, the script will append catalog number/ISRC instead.

```txt
Before:
   1_01_Noname.flac
After:
   /home/username/Torrent Uploads/FLAC/2012/[2012.12.21] ノナメ - M-chan [FLAC 24-48.0 KHz][ABCD-12345]/1-01 ノナメ.flac
```
