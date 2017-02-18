# Hairy Black Hole

Videos I bookmark seem to disappear in a black hole.

The *no-hair theorem* postulates that all information other than the observable
classical parameters: mass, electric charge, and angular momentum (for which
"hair" is a metaphor) about the matter which formed a black hole or is falling
into it, "disappears" behind the black-hole event horizon and is therefore
permanently inaccessible to external observers.
([Wikipedia](https://en.wikipedia.org/wiki/No-hair_theorem))

This program makes Firefox's bookmarks black hole hairy. It finds the total
length of all Youtube videos linked in your bookmarks.

## Installation

Add your
[Google API key](https://developers.google.com/youtube/v3/getting-started) that
has the YouTube API enabled to a file called `settings.clj`.

## Usage

    lein uberjar
    java -jar target/hairyblackhole-1.0.0-standalone.jar

## Example output

>Videos:<br>
>- 31:51MC Lectures: Social Etiquette with Nancy Mitchell - YouTube
>- Brian Beckman: Don't fear the Monad - YouTube
>- 21:00Expert to Expert: Rich Hickey and Brian Beckman - Inside Clojure - YouTube
>- Dirichlet Processes and Friends with Ryan Adams - YouTube
>- (...)
>
> Total hours: 83

## If you want to continue this project (I won't), these are some ideas

- Support YouTube playlists.
- Support Vimeo (others?).
- Support Chrome. Note: needed bookmark information available at
  ~/Library/Application Support/Google/Chrome/Default/Bookmarks.
- Turn it into a Firefox, IE, and Chrome plugin.

## License

Copyright © 2017 Erwin Rooijakkers

Distributed under the Eclipse Public License either version 1.0 or (at your
option) any later version.
