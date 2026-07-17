import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CharacterComponent } from './character-component';

describe('Character', () => {
  let component: CharacterComponent;
  let fixture: ComponentFixture<CharacterComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CharacterComponent],
    }).compileComponents();

    fixture = TestBed.createComponent(CharacterComponent);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
