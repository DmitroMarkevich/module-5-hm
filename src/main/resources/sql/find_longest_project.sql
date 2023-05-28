SELECT c.name, TIMESTAMPDIFF(MONTH, p.start_date, p.finish_date) as MONTH_COUNT FROM project p
                                                                                         JOIN client c ON p.client_id = c.id
WHERE TIMESTAMPDIFF(MONTH, p.start_date, p.finish_date) = (SELECT MAX(TIMESTAMPDIFF(MONTH, start_date, finish_date))
                                                           FROM project);
