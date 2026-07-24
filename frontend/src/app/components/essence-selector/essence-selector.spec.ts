import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EssenceSelector } from './essence-selector';

describe('EssenceSelector', () => {
  let component: EssenceSelector;
  let fixture: ComponentFixture<EssenceSelector>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [EssenceSelector],
    }).compileComponents();

    fixture = TestBed.createComponent(EssenceSelector);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
