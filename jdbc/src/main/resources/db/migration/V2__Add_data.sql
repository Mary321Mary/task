INSERT INTO public.users(id, username, password, role)
	VALUES (1, 'mary', '$2a$12$TJIUl8Mtw4p8/DVQ6lkLLuFXcMW0xtsmpGS1EhZID28STdF2XpNbi', 'admin');
INSERT INTO public.users(id, username, password, role)
	VALUES (2, 'nana', '$2a$12$1nJIL4QGUaXCQplgm7inouXMyC3aqRlDQ0XxUKD8w.esi6IN06b7a', 'user');

INSERT INTO public.car(
	id, name, model, generation, mileage, engine, user_id, price, deleted)
	VALUES (1, 'SEAT Toledo I Original', 'Toledo', 'I', '178 469 km', 'Gasoline', 1, 2723, false);
INSERT INTO public.car(
	id, name, model, generation, mileage, engine, user_id, price, deleted)
	VALUES (2, 'ЗАЗ 968 I', '968', 'I', '4 000 km', 'Gasoline', 2, 3811, false);
INSERT INTO public.car(
	id, name, model, generation, mileage, engine, user_id, price, deleted)
	VALUES (3, 'Buick Envision I Premium II Titanium', 'Envision', 'I', '77 000 km', 'Gasoline', 1, 46320, false);
INSERT INTO public.car(
	id, name, model, generation, mileage, engine, user_id, price, deleted)
	VALUES (4, 'Buick Regal V / Premium ll - AWD', 'Regal', 'V', '67 000 km', 'Gasoline', 2, 34066, false);
INSERT INTO public.car(
	id, name, model, generation, mileage, engine, user_id, price, deleted)
	VALUES (5, 'Volkswagen Passat B8 LED', 'Passat', 'B8', '230 000 km', 'Diesel', 1, 44359, false);
INSERT INTO public.car(
	id, name, model, generation, mileage, engine, user_id, price, deleted)
	VALUES (6, 'Volkswagen Polo V', 'Polo', 'V', '70 000 km', 'Gasoline', 2, 31860, false);
INSERT INTO public.car(
	id, name, model, generation, mileage, engine, user_id, price, deleted)
	VALUES (7, 'Volkswagen Tiguan I', 'Tiguan', 'I', '140 000 km', 'Gasoline', 1, 29410, true);
INSERT INTO public.car(
	id, name, model, generation, mileage, engine, user_id, price, deleted)
	VALUES (8, 'Volkswagen Passat B5', 'Passat', 'B5', '320 000 km', 'Gasoline', 1, 12987, true);
