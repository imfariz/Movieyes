package com.dicoding.movieyes.utils

import com.dicoding.movieyes.data.source.local.entity.ShowEntity
import com.dicoding.movieyes.data.source.remote.response.ResultsMovies
import com.dicoding.movieyes.data.source.remote.response.SeriesItem

object DataDummy {
    fun generateDummyMovies(): List<ShowEntity> {
        val shows = ArrayList<ShowEntity>()

        shows.add(
            ShowEntity(
                11,
                "Spiderman : No Way Home",
                "Peter Parker is unmasked and no longer able to separate his normal life from the high-stakes of being a super-hero. When he asks for help from Doctor Strange the stakes become even more dangerous, forcing him to discover what it truly means to be Spider-Man.",
                "12/17/2021 ",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/1g0dhYtq4irTY1GPXvft6k4YLjm.jpg",
                8.4,
                false,
                false
            )
        )

        shows.add(
            ShowEntity(
                12,
                "Venom : Let There Be Carnage",
                "life from the high-stakes of being a super-hero. When he asks for help from Doctor Strange the stakes become even more dangerous, forcing him to discover what it truly means to be Spider-Man.",
                "10/01/2021",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/rjkmN1dniUHVYAtwuV3Tji7FsDO.jpg",
                8.5,
                false,
                false
            )
        )

        shows.add(
            ShowEntity(
                13,
                "Shang-Chi and the Legend of the Ten Rings",
                "Shang-Chi must confront the past he thought he left behind when he is drawn into the web of the mysterious Ten Rings organization.",
                "2021-09-01",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/1BIoJGKbXjdFDAqUEiA2VHqkK1Z.jpg",
                8.8,
                false,
                false
            )
        )

        shows.add(
            ShowEntity(
                14,
                "The Amazing Spider-Man",
                "Peter Parker is an outcast high schooler abandoned by his parents as a boy, leaving him to be raised by his Uncle Ben and Aunt May. Like most teenagers, Peter is trying to figure out who he is and how he got to be the person he is today. As Peter discovers a mysterious briefcase that belonged to his father, he begins a quest to understand his parents' disappearance – leading him directly to Oscorp and the lab of Dr. Curt Connors, his father's former partner. As Spider-Man is set on a collision course with Connors' alter ego, The Lizard, Peter will make life-altering choices to use his powers and shape his destiny to become a hero.",
                "07/04/2012 ",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/fSbqPbqXa7ePo8bcnZYN9AHv6zA.jpg",
                7.7,
                false,
                false
            )
        )

        shows.add(
            ShowEntity(
                15,
                "The Amazing Spider-Man 2",
                "For Peter Parker, life is busy. Between taking out the bad guys as Spider-Man and spending time with the person he loves, Gwen Stacy, high school graduation cannot come quickly enough. Peter has not forgotten about the promise he made to Gwen’s father to protect her by staying away, but that is a promise he cannot keep. Things will change for Peter when a new villain, Electro, emerges, an old friend, Harry Osborn, returns, and Peter uncovers new clues about his past.",
                "05/02/2014",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/c3e9e18SSlvFd1cQaGmUj5tqL5P.jpg",
                5.3,
                false,
                false
            )
        )

        shows.add(
            ShowEntity(
                16,
                "Spider-Man",
                "After being bitten by a genetically altered spider at Oscorp, nerdy but endearing high school student Peter Parker is endowed with amazing powers to become the superhero known as Spider-Man.",
                "05/22/2002",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/gh4cZbhZxyTbgxQPxD0dOudNPTn.jpg",
                6.4,
                false,
                false
            )
        )

        shows.add(
            ShowEntity(
                17,
                "Spider-Man 2",
                "Peter Parker is going through a major identity crisis. Burned out from being Spider-Man, he decides to shelve his superhero alter ego, which leaves the city suffering in the wake of carnage left by the evil Doc Ock. In the meantime, Parker still can't act on his feelings for Mary Jane Watson, a girl he's loved since childhood. A certain anger begins to brew in his best friend Harry Osborn as well",
                "06/30/2004",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/olxpyq9kJAZ2NU1siLshhhXEPR7.jpg",
                7.8,
                false,
                false
            )
        )

        shows.add(
            ShowEntity(
                18,
                "Spider-Man 3",
                "The seemingly invincible Spider-Man goes up against an all-new crop of villains—including the shape-shifting Sandman. While Spider-Man’s superpowers are altered by an alien organism, his alter ego, Peter Parker, deals with nemesis Eddie Brock and also gets caught up in a love triangle.",
                "05/03/2007 ",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/qFmwhVUoUSXjkKRmca5yGDEXBIj.jpg",
                8.9,
                false,
                false
            )
        )

        shows.add(
            ShowEntity(
                19,
                "Mulan",
                "When the Emperor of China issues a decree that one man per family must serve in the Imperial Chinese Army to defend the country from Huns, Hua Mulan, the eldest daughter of an honored warrior, steps in to take the place of her ailing father. She is spirited, determined and quick on her feet. Disguised as a man by the name of Hua Jun, she is tested every step of the way and must harness her innermost strength and embrace her true potential.",
                "09/04/2020",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/aKx1ARwG55zZ0GpRvU2WrGrCG9o.jpg",
                6.7,
                false,
                false
            )
        )

        shows.add(
            ShowEntity(
                110,
                "The Matrix Resurrections",
                "Plagued by strange memories, Neo's life takes an unexpected turn when he finds himself back inside the Matrix.",
                "12/22/2021",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/gZlZLxJMfnSeS60abFZMh1IvODQ.jpg",
                7.8,
                false,
                false
            )
        )

        shows.add(
            ShowEntity(
                21,
                "LOL: Last One Laughing",
                "An unscripted variety series from Mexico in which ten professional comedians compete for a cash prize by trying to make each other laugh. The one who refrains from laughing the longest, while forcing other contestants to laugh first, is the winner.",
                "2018",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/85Fx3ax4PLQlAODI1K8Kk0kAUdO.jpg",
                5.4,
                true,
                false
            )
        )

        shows.add(
            ShowEntity(
                22,
                "Naruto Shippuden",
                "Naruto Shippuuden is the continuation of the original animated TV series Naruto.The story revolves around an older and slightly more matured Uzumaki Naruto and his quest to save his friend Uchiha Sasuke from the grips of the snake-like Shinobi, Orochimaru. After 2 and a half years Naruto finally returns to his village of Konoha, and sets about putting his ambitions to work, though it will not be easy, as He has amassed a few (more dangerous) enemies, in the likes of the shinobi organization; Akatsuki.",
                "2007",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/kV27j3Nz4d5z8u6mN3EJw9RiLg2.jpg",
                6.9,
                true,
                false
            )
        )

        shows.add(
            ShowEntity(
                23,
                "The Book of Boba Fett",
                "Legendary bounty hunter Boba Fett and mercenary Fennec Shand must navigate the galaxy’s underworld when they return to the sands of Tatooine to stake their claim on the territory once ruled by Jabba the Hutt and his crime syndicate.",
                "2021",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/gNbdjDi1HamTCrfvM9JeA94bNi2.jpg",
                4.4,
                true,
                false
            )
        )

        shows.add(
            ShowEntity(
                24,
                "Cobra Kai",
                "This Karate Kid sequel series picks up 30 years after the events of the 1984 All Valley Karate Tournament and finds Johnny Lawrence on the hunt for redemption by reopening the infamous Cobra Kai karate dojo. This reignites his old rivalry with the successful Daniel LaRusso, who has been working to maintain the balance in his life without mentor Mr. Miyagi.",
                "2018",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/6POBWybSBDBKjSs1VAQcnQC1qyt.jpg",
                7.0,
                true,
                false
            )
        )

        shows.add(
            ShowEntity(
                25,
                "The Flash",
                "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \"meta-human\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.",
                "2014",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/lJA2RCMfsWoskqlQhXPSLFQGXEJ.jpg",
                6.8,
                true,
                false
            )
        )

        shows.add(
            ShowEntity(
                26,
                "The Witcher",
                "Geralt of Rivia, a mutated monster-hunter for hire, journeys toward his destiny in a turbulent world where people often prove more wicked than beasts.",
                "2019",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/7vjaCdMw15FEbXyLQTVa04URsPm.jpg",
                7.8,
                true,
                false
            )
        )

        shows.add(
            ShowEntity(
                27,
                "Squid Game",
                "Hundreds of cash-strapped players accept a strange invitation to compete in children's games—with high stakes. But, a tempting prize awaits the victor.",
                "2021",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/dDlEmu3EZ0Pgg93K2SVNLCjCSvE.jpg",
                7.2,
                true,
                false
            )
        )

        shows.add(
            ShowEntity(
                28,
                "Peaky Blinders",
                "A gangster family epic set in 1919 Birmingham, England and centered on a gang who sew razor blades in the peaks of their caps, and their fierce boss Tommy Shelby, who means to move up in the world.",
                "2013",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/bGZn5RVzMMXju4ev7xbl1aLdXqq.jpg",
                8.2,
                true,
                false
            )
        )

        shows.add(
            ShowEntity(
                29,
                "Grey's Anatomy",
                "Follows the personal and professional lives of a group of doctors at Seattle’s Grey Sloan Memorial Hospital.",
                "2005",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/zPIug5giU8oug6Xes5K1sTfQJxY.jpg",
                9.2,
                true,
                false
            )
        )

        shows.add(
            ShowEntity(
                210,
                "Riverdale",
                "Set in the present, the series offers a bold, subversive take on Archie, Betty, Veronica and their friends, exploring the surreality of small-town life, the darkness and weirdness bubbling beneath Riverdale’s wholesome facade.",
                "2017",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/xBaeUYKNJfX8VhIFvvgPpFSYxBZ.jpg",
                8.2,
                true,
                false
            )
        )

        return shows
    }

    fun generateRemoteDetailsDummyMovies(): List<ResultsMovies> {
        val shows = ArrayList<ResultsMovies>()
        shows.add(
            ResultsMovies(
                524434,
                "Eternals",
                "The Eternals are a team of ancient aliens who have been living on Earth in secret for thousands of years. When an unexpected tragedy forces them out of the shadows, they are forced to reunite against mankind’s most ancient enemy, the Deviants.",
                "2021-11-03",
                "/b6qUu00iIIkXX13szFy7d0CyNcg.jpg",
                7.2
            )
        )
        shows.add(
            ResultsMovies(
                438695,
                "Sing 2",
                "Buster and his new cast now have their sights set on debuting a new show at the Crystal Tower Theater in glamorous Redshore City. But with no connections, he and his singers must sneak into the Crystal Entertainment offices, run by the ruthless wolf mogul Jimmy Crystal, where the gang pitches the ridiculous idea of casting the lion rock legend Clay Calloway in their show. Buster must embark on a quest to find the now-isolated Clay and persuade him to return to the stage.",
                "2021-12-01",
                "/aWeKITRFbbwY8txG5uCj4rMCfSP.jpg",
                8.3
            )
        )
        shows.add(
            ResultsMovies(
                634649,
                "Spider-Man: No Way Home",
                "Peter Parker is unmasked and no longer able to separate his normal life from the high-stakes of being a super-hero. When he asks for help from Doctor Strange the stakes become even more dangerous, forcing him to discover what it truly means to be Spider-Man.",
                "2021-12-15",
                "/1g0dhYtq4irTY1GPXvft6k4YLjm.jpg",
                8.4
            )
        )
        shows.add(
            ResultsMovies(
                425909,
                "Ghostbusters: Afterlife",
                "When a single mom and her two kids arrive in a small town, they begin to discover their connection to the original Ghostbusters and the secret legacy their grandfather left behind.",
                "2021-11-11",
                "/sg4xJaufDiQl7caFEskBtQXfD4x.jpg",
                7.7
            )
        )
        shows.add(
            ResultsMovies(
                568124,
                "Encanto",
                "The tale of an extraordinary family, the Madrigals, who live hidden in the mountains of Colombia, in a magical house, in a vibrant town, in a wondrous, charmed place called an Encanto. The magic of the Encanto has blessed every child in the family with a unique gift from super strength to the power to heal—every child except one, Mirabel. But when she discovers that the magic surrounding the Encanto is in danger, Mirabel decides that she, the only ordinary Madrigal, might just be her exceptional family's last hope.",
                "2021-11-24",
                "4j0PNHkMr5ax3IA8tjtxcmPU3QT.jpg",
                7.8
            )
        )
        return shows
    }

    fun generateRemoteDummySeries(): List<SeriesItem> {
        val shows = ArrayList<SeriesItem>()
        shows.add(
            SeriesItem(
                85552,
                "Euphoria",
                "A group of high school students navigate love and friendships in a world of drugs, sex, trauma, and social media.",
                "2019-06-16",
                "/jtnfNzqZwN4E32FGGxx1YZaBWWf.jpg",
                8.4
            )
        )
        shows.add(
            SeriesItem(
                77169,
                "Cobra Kai",
                "This Karate Kid sequel series picks up 30 years after the events of the 1984 All Valley Karate Tournament and finds Johnny Lawrence on the hunt for redemption by reopening the infamous Cobra Kai karate dojo. This reignites his old rivalry with the successful Daniel LaRusso, who has been working to maintain the balance in his life without mentor Mr. Miyagi.",
                "2018-05-02",
                "/6POBWybSBDBKjSs1VAQcnQC1qyt.jpg",
                8.1
            )
        )
        shows.add(
            SeriesItem(
                115036,
                "The Book of Boba Fett",
                "Legendary bounty hunter Boba Fett and mercenary Fennec Shand must navigate the galaxy’s underworld when they return to the sands of Tatooine to stake their claim on the territory once ruled by Jabba the Hutt and his crime syndicate.",
                "2021-12-29",
                "/gNbdjDi1HamTCrfvM9JeA94bNi2.jpg",
                8.1
            )
        )
        shows.add(
            SeriesItem(
                71914,
                "The Wheel of Time",
                "Follow Moiraine, a member of the shadowy and influential all-female organization called the “Aes Sedai” as she embarks on a dangerous, world-spanning journey with five young men and women. Moiraine believes one of them might be the reincarnation of an incredibly powerful individual, whom prophecies say will either save humanity or destroy it.",
                "2021-11-18",
                "/mpgDeLhl8HbhI03XLB7iKO6M6JE.jpg",
                7.9
            )
        )
        shows.add(
            SeriesItem(
                96777,
                "The Silent Sea",
                "During a perilous 24-hour mission on the moon, space explorers try to retrieve samples from an abandoned research facility steeped in classified secrets.",
                "2021-12-24",
                "/fFT0IgqtCOks4munDTxQwkvNJkd.jpg",
                8.1
            )
        )
        return shows
    }

    fun generateMovies(): List<ShowEntity> {
        val shows = ArrayList<ShowEntity>()
        val movies = generateRemoteDetailsDummyMovies()
        for (movie in movies) {
            shows.add(
                ShowEntity(
                    movie.id,
                    movie.title,
                    movie.overview,
                    movie.releaseDate,
                    movie.posterPath,
                    movie.voteAverage,
                    false,
                    false
                )
            )
        }
        return shows
    }

    fun generateSeries(): List<ShowEntity> {
        val shows = ArrayList<ShowEntity>()
        val movies = generateRemoteDummySeries()
        for (movie in movies) {
            shows.add(
                ShowEntity(
                    movie.id,
                    movie.name,
                    movie.overview,
                    movie.firstAirDate,
                    movie.posterPath,
                    movie.voteAverage,
                    true,
                    false
                )
            )
        }
        return shows
    }

    fun generateMovieBookmarked(): List<ShowEntity> {
        val shows = ArrayList<ShowEntity>()

        shows.add(
            ShowEntity(
                11,
                "Spiderman : No Way Home",
                "Peter Parker is unmasked and no longer able to separate his normal life from the high-stakes of being a super-hero. When he asks for help from Doctor Strange the stakes become even more dangerous, forcing him to discover what it truly means to be Spider-Man.",
                "12/17/2021 ",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/1g0dhYtq4irTY1GPXvft6k4YLjm.jpg",
                8.4,
                false,
                true
            )
        )

        shows.add(
            ShowEntity(
                12,
                "Venom : Let There Be Carnage",
                "life from the high-stakes of being a super-hero. When he asks for help from Doctor Strange the stakes become even more dangerous, forcing him to discover what it truly means to be Spider-Man.",
                "10/01/2021",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/rjkmN1dniUHVYAtwuV3Tji7FsDO.jpg",
                8.5,
                false,
                true
            )
        )
        return shows
    }

    fun getSerieBookmarked(): List<ShowEntity> {
        val shows = ArrayList<ShowEntity>()

        shows.add(
            ShowEntity(
                21,
                "LOL: Last One Laughing",
                "An unscripted variety series from Mexico in which ten professional comedians compete for a cash prize by trying to make each other laugh. The one who refrains from laughing the longest, while forcing other contestants to laugh first, is the winner.",
                "2018",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/85Fx3ax4PLQlAODI1K8Kk0kAUdO.jpg",
                5.4,
                true,
                false
            )
        )

        shows.add(
            ShowEntity(
                22,
                "Naruto Shippuden",
                "Naruto Shippuuden is the continuation of the original animated TV series Naruto.The story revolves around an older and slightly more matured Uzumaki Naruto and his quest to save his friend Uchiha Sasuke from the grips of the snake-like Shinobi, Orochimaru. After 2 and a half years Naruto finally returns to his village of Konoha, and sets about putting his ambitions to work, though it will not be easy, as He has amassed a few (more dangerous) enemies, in the likes of the shinobi organization; Akatsuki.",
                "2007",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/kV27j3Nz4d5z8u6mN3EJw9RiLg2.jpg",
                6.9,
                true,
                false
            )
        )

        return shows
    }
}