ALTER TABLE event
ALTER COLUMN description TYPE varchar(800);


INSERT INTO "user" (id, username, email, first_name, last_name)
VALUES ('4a0e6ebe-7819-49e7-b724-feec987f9ad6', 'SunFlower','sunny@gmail.com', 'Sunny', 'Adams'),
       ('d894b86d-4b4b-449c-aea6-444065e0f4e2', 'HazelNut', 'hazel@yahoo.com', 'Hazel', 'Smith'),
       ('1cc30581-129b-4ea5-bb47-3d916797f062', 'Beaver_Hut', 'beaver@mail.com', 'Bruno', 'Mercury'),
       ('27138000-3b87-49ff-9143-62e324d3c2cb', 'DeerLight', 'lights@gmail.com', 'John', 'Jones');

INSERT INTO event (id, title, description, category, date, end_date, location, price, organizer_id)
VALUES ('e077f9cb-bbf5-4df7-a4ab-744c7f904eb8',
        'GameCon','GameCon is a 4-day summer event for anyone who loves fun and non-computer games of any kind: ' ||
                  'board games, tabletop RPGs, LARPs, Wargaming, social games, party games, or anything similar or in between.',
        'GAMES', CURRENT_TIMESTAMP, '2024-04-16 23:30:00.000000', 'Pardubice, Czech Republic', 2.55, '4a0e6ebe-7819-49e7-b724-feec987f9ad6'),

        ('e482188b-fe15-4e8b-8e77-d4e6a42231ee',
        'VR filmas Angelų takais',
         'virtualios realybės animacija, pristatanti tarpdisciplininio meno pirmtako ir vieno abstrakčiojo meno pionierių Europoje Mikalojaus Konstantino Čiurlionio kūrybinį palikimą',
        'CHILDREN', '2024-04-28 14:00:00.000000', '2024-04-28 16:00:00.000000', 'M. K. Čiurlionio namai Savičiaus g. 11', 0,
         '4a0e6ebe-7819-49e7-b724-feec987f9ad6'),

        ('f68957a6-3896-4be3-970d-282ad7aec0d7',
        'Paroda Vilniaus laikas',
         'Parodoje „Vilniaus laikas“ sutelkta daugiau nei 200 eksponatų, tarp jų – tapybos ir grafikos darbai, skulptūriniai projektai, fotografijos, miesto planai, smulkieji spaudiniai, auksakalių dirbiniai, istoriniai dokumentai',
        'EXHIBITION', '2023-06-01 00:00:00.000000', '2024-05-01 00:00:00.000000',
         'Lietuvos meno pažinimo centras Tartle Užupio g. 40', 8.00,
        '27138000-3b87-49ff-9143-62e324d3c2cb');