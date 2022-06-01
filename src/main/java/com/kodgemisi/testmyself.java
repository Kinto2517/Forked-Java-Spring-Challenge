package com.kodgemisi;

import com.kodgemisi.usermanagement.*;

import java.time.Instant;
import java.util.Set;

public class testmyself {

    public static void main(String[] args) {

        UserService userService = new UserService(new UserDaoImpl());

        User raffaello = new User(
                null,
                new Profile(
                        "https://upload.wikimedia.org/wikipedia/commons/thumb/f/f6/Raffaello_Sanzio.jpg/330px-Raffaello_Sanzio.jpg",
                        "Urbino, Italy",
                        new Phone("+192242558213"),
                        new Email("arnold@sbcglobal.net"),
                        Set.of(new Phone("+233224582360")),
                        Set.of(new Email("preneel@me.com")),
                        Language.EN
                ),
                11,
                false,
                Role.ANONYMOUS,
                Instant.now()
        );
        userService.create(raffaello);
        System.out.println(userService.list().get(0).getProfile().getAddress()+"\n\n");


        raffaello = new User(
                raffaello.getId(),
                new Profile(
                        raffaello.getProfile().getAvatarUrl(),
                        "Florida, U.S.",
                        new Phone("+232972510919"),
                        raffaello.getProfile().getPrimaryEmail(),
                        raffaello.getProfile().getPhones(),
                        raffaello.getProfile().getEmails(),
                        Language.EN
                ),
                23,
                true,
                Role.ADMIN,
                raffaello.getCreatedAt()
        );

        System.out.println("\n\nRafaello\n"+raffaello.getProfile().getAddress());

        var updatedRafaello = userService.update(raffaello);

        System.out.println("\n\nupdated rafaello\n"+updatedRafaello.getProfile().getAddress());



    }
}
