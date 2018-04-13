/*
 * DISCLAIMER
 *
 * Copyright 2017 ArangoDB GmbH, Cologne, Germany
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Copyright holder is ArangoDB GmbH, Cologne, Germany
 */

package io.github.ganchix.arangodb.domain;

import java.util.Collection;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import com.arangodb.springframework.annotation.Document;
import com.arangodb.springframework.annotation.HashIndex;
import com.arangodb.springframework.annotation.Relations;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("characters")
@HashIndex(fields = { "name", "surname" }, unique = true)
public class CharacterActor {

	@Id
	private String id;

	private String name;
	private String surname;
	private boolean alive;
	private Integer age;
	@Relations(edges = ChildOf.class, lazy = true)
	private Collection<CharacterActor> childs;


	public CharacterActor(final String name, final String surname, final boolean alive) {
		super();
		this.name = name;
		this.surname = surname;
		this.alive = alive;
	}

	public CharacterActor(final String name, final String surname, final boolean alive, final Integer age) {
		super();
		this.name = name;
		this.surname = surname;
		this.alive = alive;
		this.age = age;
	}

}
